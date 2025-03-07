package com.teknoserval.arcanedustry.spell;

import net.minecraft.world.entity.Entity;

public interface SpellTarget {

    static SpellTarget of(Entity entity) {
        return new SpellTargetEntity(entity);
    }

    Class<?> getTargetClass();

    Object getTarget();
}
