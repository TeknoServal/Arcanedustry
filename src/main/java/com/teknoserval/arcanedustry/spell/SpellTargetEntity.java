package com.teknoserval.arcanedustry.spell;

import net.minecraft.world.entity.Entity;

public class SpellTargetEntity implements SpellTarget {

    private final Entity target;

    public SpellTargetEntity(Entity target) {
        this.target = target;
    }

    @Override
    public Class<Entity> getTargetClass() {
        return Entity.class;
    }

    @Override
    public Object getTarget() {
        return target;
    }
}
