package com.sandbox.project.controller;

import com.sandbox.project.dto.ShareContractRequestDto;
import com.sandbox.project.dto.ShareContractResponseDto;
import com.sandbox.project.service.ShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contract")
@RequiredArgsConstructor
public class ContractController {

    private final ShareService shareService;

    @RequestMapping(value = "/{contractID}", method = RequestMethod.POST)
    public ResponseEntity<ShareContractResponseDto> setContractInfo(@RequestBody ShareContractRequestDto shareContractRequestDto){
        return ResponseEntity.ok(shareService.setShareContractInfo(shareContractRequestDto));
    }

    @RequestMapping(value = "/{contractID}", method = RequestMethod.GET)
    public ResponseEntity<ShareContractResponseDto> getContractInfo(@PathVariable String contractID){
        return ResponseEntity.ok(shareService.getShareContractInfo(contractID));
    }


}
