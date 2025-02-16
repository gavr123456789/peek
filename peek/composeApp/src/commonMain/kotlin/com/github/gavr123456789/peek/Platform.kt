package com.github.gavr123456789.peek

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform