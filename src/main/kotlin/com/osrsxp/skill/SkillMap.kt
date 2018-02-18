package com.osrsxp.skill

/**
 * Use to map API values to their actual skill values.
 */
enum class SkillMap(val skill: String, val rankIndex: Int, val levelIndex: Int, val xpIndex: Int) {
    OVERALL("Overall", 0,1,2),
    ATTACK("Attack", 3, 4, 5),
    STRENGTH("Strength", 6, 7, 8),
    HITPOINTS("Hitpoints", 9, 10, 11),
    RANGED("Ranged",12, 13, 14),
    PRAYER("Prayer", 15, 16, 17),
    MAGIC("Magic",18, 19, 20),
    WOODCUTTING("Woodcutting",21, 22, 23),
    FLETCHING("Fletching",24, 25, 26),
    FISHING("Fishing",27, 28, 29),
    CRAFTING("Crafting",30, 31, 32),
    HERBLORE("Herblore",33, 34, 35),
    AGILITY("Agility",36, 37, 38),
    SLAYER("Slayer",39, 40, 41),
    FARMING("Farming",42, 43, 44),
    RUNECRAFTING("Runecraft",45, 46, 47),
    HUNTER("Hunter",48, 49, 50),
    CONSTRUCTION("Construction",51, 52, 53),
}
