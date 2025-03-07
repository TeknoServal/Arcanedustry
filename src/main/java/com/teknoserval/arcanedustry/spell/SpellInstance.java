package com.teknoserval.arcanedustry.spell;

import net.minecraft.world.entity.Entity;

import java.util.HashMap;
import java.util.Map;

public class SpellInstance {

    private SpellShardSequence shardSequence;
    private SpellTarget target;
    private Map<SpellRune, Object> spellData = new HashMap<>();
    private int step = 0;

    public SpellInstance(SpellShardSequence shardSequence, Entity caster) {
        this.shardSequence = shardSequence;
        this.target = SpellTarget.of(caster);
    }

    public void castNextShard() {
        SpellShard shard = shardSequence.getShards().get(step);

        step = shard.processShardAndGetNextStep(this);
    }

    public SpellShardSequence getShardSequence() {
        return shardSequence;
    }

    public SpellTarget getTarget() {
        return target;
    }

    public Map<SpellRune, Object> getSpellData() {
        return spellData;
    }

    public int getStep() {
        return step;
    }
}
