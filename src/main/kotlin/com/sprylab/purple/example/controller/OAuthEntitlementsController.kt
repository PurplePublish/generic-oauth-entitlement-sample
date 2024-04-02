package com.sprylab.purple.example.controller

import com.sprylab.purple.example.model.EntitlementErrorCode
import com.sprylab.purple.example.model.GenericEntitlementError
import com.sprylab.purple.example.model.UniversalEntitlement
import com.sprylab.purple.example.model.UserEntitlement
import mu.KLogging
import org.springframework.http.HttpStatus
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
class OAuthEntitlementsController {

    companion object : KLogging()

    @GetMapping("/v1/entitlements")
    fun entitlements(
        @RequestParam appId: String,
        @RequestParam deviceId: String,
        authentication: Authentication
    ): List<UserEntitlement> {
        logger.info { "Allowing access to app for ${(authentication.principal as Jwt).claims["email"]}" }
        return listOf(
            UniversalEntitlement(appId)
        )
    }

    @ExceptionHandler(ResponseStatusException::class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    fun responseToBody(e: ResponseStatusException): GenericEntitlementError {
        return GenericEntitlementError(
            code = EntitlementErrorCode.AUTHENTICATION_ERROR,
            message = e.reason ?: "Invalid credentials"
        )
    }

}
