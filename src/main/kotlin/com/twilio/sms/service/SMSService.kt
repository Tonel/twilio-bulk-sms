package com.twilio.sms.service

import com.twilio.sms.config.TwilioConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber

@Service
class SMSService (
    @Autowired private val twilioConfig: TwilioConfig
)  {
    fun sendSingleSMS() {
        // sender phone number
        val from = PhoneNumber(twilioConfig.phoneNumber)
        // receiver phone number
        // (replace it with your phone number for testing)
        val to = PhoneNumber("+1555000222")
        // SMS message content
        val message = "Hello, World!"

        // send single SMS with the Twilio SMS API
        Message.creator(
            to,
            from,
            message
        ).create()
    }

    fun sendBulkSMS() {
        // phone numbers of the user to notify
        // (replace these with your phone numbers for testing)
        val numberList: List<String> = listOf(
            "+1555000200",
            "+1555000201",
            // ...
            "+1555000300"
        )

        // SMS message content
        val message = "Hello, World!"

        // send bulk SMS in parallel
        numberList
            .parallelStream()
            .forEach {
                    phoneNumber ->
                // send single SMS with the Twilio SMS API
                Message.creator(
                    PhoneNumber(phoneNumber),
                    twilioConfig.messagingServiceSid,
                    message
                ).create()
            }
    }
}