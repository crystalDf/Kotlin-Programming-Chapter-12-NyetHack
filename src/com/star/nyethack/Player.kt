package com.star.nyethack

import kotlin.math.min
import kotlin.math.pow

class Player {

    var name = "star"
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }

    var healthPoints = 89
    var isBlessed = true
    private val isImmortal = false

    fun formatAuraColor() = if ((isBlessed && healthPoints > 50) || isImmortal) {
        when ((Math.random().pow((110 - healthPoints) / 100.0) * 20).toInt()) {
            in 0..5 -> "RED"
            in 6..10 -> "ORANGE"
            in 11..15 -> "PURPLE"
            in 16..20 -> "GREEN"
            else -> "NONE"
        }
    } else "NONE"

    fun formatHealthStatus() =
        when (healthPoints) {
            100 -> "is in excellent condition!"
            in 90..99 -> "has a few scratches."
            in 75..89 -> if (isBlessed) {
                "has some minor wounds but is healing quite quickly!"
            } else {
                "has some minor wounds."
            }
            in 15..74 -> "looks pretty hurt."
            else -> "is in awful condition!"
        }

    fun castFireball(numFireballs: Int = 2): String {
        println("A glass of Fireball springs into existence. (x$numFireballs)")

        return when ((min(numFireballs, 100) + 1) / 2) {
            in 1..10 -> "tipsy"
            in 11..20 -> "sloshed"
            in 21..30 -> "soused"
            in 31..40 -> "stewed"
            in 41..50 -> "..t0aSt3d"
            else -> ""
        }
    }
}