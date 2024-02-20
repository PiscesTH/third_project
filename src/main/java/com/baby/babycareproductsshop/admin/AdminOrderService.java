package com.baby.babycareproductsshop.admin;

import com.baby.babycareproductsshop.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminOrderService {
    private final AdminOrderMapper mapper;
    private final AuthenticationFacade authenticationFacade;

}
