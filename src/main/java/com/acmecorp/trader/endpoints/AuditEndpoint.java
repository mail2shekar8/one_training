package com.acmecorp.trader.endpoints;


import com.acmecorp.trader.domain.AuditRecord;
import com.acmecorp.trader.repository.AuditTrailDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by volen on 2017-07-31.
 */
@RestController
@RequestMapping(value = "/audit")
public class AuditEndpoint {
    @Autowired
    @Qualifier("auditTrailDAO")
    AuditTrailDAO auditTrailDAO;

    @GetMapping
    public List<AuditRecord> findAuditRecords(@RequestParam(value="from", defaultValue=MIN_TS, required=false) long from,
    										  @RequestParam(value="to",   defaultValue=MAX_TS, required=false) long to) {
        return auditTrailDAO.findAuditRecords(from, to);
    }

/*
    @GetMapping
    public List<AuditRecord> listAuditRecords() {
        return auditTrailDAO.getAllAuditRecords();
    }
*/    
    
    //-------
    private static final String MIN_TS = "0";
    private static final String MAX_TS = "9223372036854775807";

}
