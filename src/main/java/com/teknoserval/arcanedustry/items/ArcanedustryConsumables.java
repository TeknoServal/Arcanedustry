package com.teknoserval.arcanedustry.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import static net.minecraft.world.item.component.Consumables.defaultFood;

/**
 * Custom consumables for Arcanedustry
 */
public class ArcanedustryConsumables {

    public static final Consumable MAGIC_GOO = defaultFood().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.CONFUSION, 400, 1))).build();
}
