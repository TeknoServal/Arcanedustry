package com.teknoserval.arcanedustry.spell;

import net.minecraft.world.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class SpellShardSequence {

    private List<SpellShard> shards = new ArrayList<>();

    public SpellShardSequence(List<SpellShard> shards) {
        this.shards.addAll(shards);
    }

    public void addShard(SpellShard shard) {
        this.shards.add(shard);
    }

    public SpellInstance cast(Entity caster) {
        SpellInstance spellInstance = new SpellInstance(this, caster);

        spellInstance.castNextShard();
        return spellInstance;
    }

    public List<SpellShard> getShards() {
        return shards;
    }
}
