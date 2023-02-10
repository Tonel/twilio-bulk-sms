package com.twilio.sms.config

import com.twilio.Twilio
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class TwilioConfig(
    // read Twilio ACCOUNT SID from application.properties
    @Value("\${twilio.account-sid}") val accountSid: String,
    // read Twilio AUTH TOKEN from application.properties
    @Value("\${twilio.auth-token}") val authToken: String,
    // read Twilio PHONE NUMBER from application.properties
    @Value("\${twilio.phone-number}") val phoneNumber: String,
    // read Twilio MESSAGING SERVICE SID from application.properties
    @Value("\${twilio.messaging-service-sid}") val messagingServiceSid: String
) {
    @PostConstruct
    fun twilioInit() {
        // initialize Twilio
        Twilio.init(
            accountSid,
            authToken
        )
    }
}