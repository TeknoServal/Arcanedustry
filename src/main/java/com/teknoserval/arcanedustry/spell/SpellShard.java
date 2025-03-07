package com.teknoserval.arcanedustry.spell;

import java.util.List;

public abstract class SpellShard {

    private final List<SpellShardInput> inputs;

    public SpellShard(List<SpellShardInput> inputs) {
        this.inputs = inputs;
    }

    public int processShardAndGetNextStep(SpellInstance instance) {



        return instance.getStep() + 1;
    }
}
