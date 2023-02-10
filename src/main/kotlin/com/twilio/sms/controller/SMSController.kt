package com.twilio.sms.controller

import com.twilio.sms.service.SMSService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/sms")
class SMSController(
    @Autowired private val smsService: SMSService
) {
    @PostMapping("sendSingleSMS")
    fun postSMS() : ResponseEntity<String> {
        // send an SMS
        smsService.sendSingleSMS()

        return ResponseEntity<String>(
            "Single SMS sent successfully!",
            HttpStatus.OK
        )
    }

    @PostMapping("sendBulkSMS")
    fun postBulkSMS() : ResponseEntity<String> {
        // send bulk SMS
        smsService.sendBulkSMS()

        return ResponseEntity<String>(
            "Bulk SMS sent successfully!",
            HttpStatus.OK
        )
    }
}