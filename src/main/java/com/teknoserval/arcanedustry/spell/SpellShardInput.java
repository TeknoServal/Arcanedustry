package com.teknoserval.arcanedustry.spell;

public class SpellShardInput {

    private Class<?> inputType;
    private SpellRune inputKey;

    public SpellShardInput(Class<?> inputType, SpellRune inputKey) {
        this.inputType = inputType;
        this.inputKey = inputKey;
    }
}
