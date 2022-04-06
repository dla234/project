package com.sandbox.project.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sandbox.project.domain.QChannel;
import com.sandbox.project.domain.QChannel_sales;
import com.sandbox.project.domain.QShare_contract;
import com.sandbox.project.dto.ChannelSalasDto;
import com.sandbox.project.dto.CreatorResponseSalasDto;
import com.sandbox.project.dto.TotalSalesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ChannelSalesRepositoryImpl implements ChannelSalesRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    private final ContractRepository contractRepository;

    @Override
    public List<ChannelSalasDto> findByChannel_ChannelID(String channelID,String yearMM) {

        QChannel_sales qChannel_sales =new QChannel_sales("salas");
        QShare_contract qShare_contract=new QShare_contract("share_contract");

        BooleanBuilder booleanBuilder=new BooleanBuilder();

        if(null != yearMM) {
            DateTimeFormatter dateTimeFormatter=new DateTimeFormatterBuilder()
                    .appendPattern("yyyyMM").parseDefaulting(ChronoField.DAY_OF_MONTH,1)
                    .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                    .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                    .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                    .toFormatter();
            LocalDateTime from=LocalDateTime.parse(yearMM,dateTimeFormatter);
            LocalDateTime to=LocalDateTime.parse(yearMM,dateTimeFormatter);
            booleanBuilder.and(qChannel_sales.modified_date.between(from,to));
        }


        List<Tuple> channel_sales=jpaQueryFactory.from(qChannel_sales).
                select( qChannel_sales.profit.sum()
                        ,qChannel_sales.modified_date.yearMonth()
                        ,qChannel_sales.channel.channelID
                        ).
                groupBy(qChannel_sales.modified_date.yearMonth(),qChannel_sales.channel).
                where(qChannel_sales.channel.channelID.eq(channelID)).
                where(booleanBuilder).
                fetch();

        List<Tuple> contract_list=jpaQueryFactory
                .select(qShare_contract.creator.creatorID
                        ,qShare_contract.profitrate)
                .from(qShare_contract)
                .where(qShare_contract.channel.channelID.eq(channelID))
                .fetch();

        HashMap<String,Double> creator_contact_map=new HashMap<>();

        for (Tuple tuple : contract_list) {
            creator_contact_map.put(
                    tuple.get(qShare_contract.creator.creatorID)
                    ,tuple.get(qShare_contract.profitrate)
            );
        }

        List<ChannelSalasDto> result=new ArrayList<>();

        for (Tuple tuple : channel_sales) {

            int sum=tuple.get(qChannel_sales.profit.sum());

            //  creator [sum * rate]
            List<Map<String,Integer>> list=new ArrayList<>();

            for (String creatorID:creator_contact_map.keySet()){
                int creator_profit_sum= (int) (sum*(creator_contact_map.get(creatorID)/100));

                Map<String,Integer> creator_map=new HashMap<>();

                creator_map.put(creatorID,creator_profit_sum);

                list.add(creator_map);

            }

            ChannelSalasDto channelSalasDto=ChannelSalasDto.builder()
                    .profit(sum)
                    .date_group(tuple.get(qChannel_sales.modified_date.yearMonth()))
                    .creator_profit(list)
                    .build();

            result.add(channelSalasDto);
        }

        return result;
    }

    @Override
    public Map<String,CreatorResponseSalasDto> findByCreator_Sales(String creatorID,String yearMM) {

        QChannel_sales qChannel_sales =new QChannel_sales("channel_sales");
        QChannel qChannel=new QChannel("channel");
        QShare_contract qShare_contract=new QShare_contract("share_contract");

        List<Tuple> contract_list=jpaQueryFactory
                .select(qShare_contract.channel.channelID
                        ,qShare_contract.profitrate
                        )
                .from(qShare_contract)
                .where(qShare_contract.creator.creatorID.eq(creatorID))
                .fetch();

        HashMap<String,Double> channel_contact_map=new HashMap<>();

        for (Tuple tuple : contract_list) {
            channel_contact_map.put(
                    tuple.get(qShare_contract.channel.channelID)
                    ,tuple.get(qShare_contract.profitrate)
            );

        }

        Map<String,CreatorResponseSalasDto> result_map=new HashMap<>();

        BooleanBuilder booleanBuilder=new BooleanBuilder();

        if(null != yearMM) {
            DateTimeFormatter dateTimeFormatter=new DateTimeFormatterBuilder()
                    .appendPattern("yyyyMM").parseDefaulting(ChronoField.DAY_OF_MONTH,1)
                    .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                    .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                    .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                    .toFormatter();
            LocalDateTime from=LocalDateTime.parse(yearMM,dateTimeFormatter);
            LocalDateTime to=LocalDateTime.parse(yearMM,dateTimeFormatter);
            booleanBuilder.and(qChannel_sales.modified_date.between(from,to));
        }

        for(String channelID:channel_contact_map.keySet()){
            List<Tuple> channel_sales=jpaQueryFactory.from(qChannel_sales).
                    select( qChannel_sales.profit.sum()
                            ,qChannel_sales.modified_date.yearMonth()
                            ,qChannel_sales.channel.channelID
                    ).
                    groupBy(qChannel_sales.modified_date.yearMonth(),qChannel_sales.channel).
                    where(qChannel_sales.channel.channelID.eq(channelID)).
                    where(booleanBuilder).
                    fetch();

            double rate=channel_contact_map.get(channelID);

            int total_profit=0;

            HashMap<String,Integer> channel_total_sales_map=new HashMap<>();

            for(Tuple tuple:channel_sales){

                int total= (int) (tuple.get(qChannel_sales.profit.sum()) * (rate/100));
                int sales_date=tuple.get(qChannel_sales.modified_date.yearMonth()).intValue();

                total_profit=total_profit+total;

                channel_total_sales_map.put("sales",total);
                channel_total_sales_map.put("date",sales_date);

            }

            result_map.put(channelID,CreatorResponseSalasDto.builder().channel_profit(channel_total_sales_map).build());


        }

        return result_map;
    }


    @Override
    public Map<Integer, List<TotalSalesDto>> findBySalesChannel(String yearMM) {


        Map<Integer, List<TotalSalesDto>> result_map=new HashMap<>();

        QChannel_sales qChannel_sales =new QChannel_sales("channel_sales");
        QChannel qChannel=new QChannel("channel");
        QShare_contract qShare_contract=new QShare_contract("share_contract");

        BooleanBuilder booleanBuilder=new BooleanBuilder();

        if(null != yearMM) {
            DateTimeFormatter dateTimeFormatter=new DateTimeFormatterBuilder()
                    .appendPattern("yyyyMM").parseDefaulting(ChronoField.DAY_OF_MONTH,1)
                    .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                    .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                    .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                    .toFormatter();
            LocalDateTime from=LocalDateTime.parse(yearMM,dateTimeFormatter);
            LocalDateTime to=LocalDateTime.parse(yearMM,dateTimeFormatter);
            booleanBuilder.and(qChannel_sales.modified_date.between(from,to));
        }

        List<Tuple> contract_list=jpaQueryFactory
                .select(qShare_contract.channel.channelID
                        ,qShare_contract.profitrate.sum()
                )
                .from(qShare_contract)
                .groupBy(qShare_contract.channel.channelID)
                .fetch();

        Map<String,Double> channel_contact_map=new HashMap<>();

        for (Tuple tuple : contract_list) {
            channel_contact_map.put(
                    tuple.get(qShare_contract.channel.channelID)
                    ,tuple.get(qShare_contract.profitrate.sum())
            );

        }

        List<Tuple> month_sales_list=jpaQueryFactory
                .select(qChannel_sales.modified_date.yearMonth(),qChannel_sales.channel.channelID
                        ,qChannel_sales.profit.sum()
                        )
                .from(qChannel_sales)
                .where(booleanBuilder)
                .groupBy(qChannel_sales.modified_date.yearMonth(),qChannel_sales.channel)
                .fetch();

        int total_sales=0;
        int total_profit=0;

        for(Tuple tuple:month_sales_list){


            if(null == tuple.get(qChannel_sales.modified_date.yearMonth())){
                continue;
            }

            int month=tuple.get(qChannel_sales.modified_date.yearMonth()).intValue();

            int sum=tuple.get(qChannel_sales.profit.sum()).intValue();

            String channelID=tuple.get(qChannel_sales.channel.channelID);

            List<TotalSalesDto> list;
            if(result_map.containsKey(month)){
                list = result_map.get(month);
            }else{
                list = new ArrayList<>();
            }

            double profit_rate=channel_contact_map.get(channelID);

            int month_channel_profit= (int) (sum*(profit_rate/100));

            list.add(TotalSalesDto.builder()
                    .channelID(channelID)
                    .sum(sum).profit_sum(sum-month_channel_profit)
                    .build());

            total_sales=total_sales+sum;
            total_profit=total_profit+month_channel_profit;
            result_map.put(month,list);


        }

        return result_map;
    }
}
