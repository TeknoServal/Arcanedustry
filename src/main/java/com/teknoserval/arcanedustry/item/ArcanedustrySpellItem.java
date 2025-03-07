package com.teknoserval.arcanedustry.item;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;


public class ArcanedustrySpellItem extends Item {

    public ArcanedustrySpellItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
//        ItemStack itemstack = player.getItemInHand(hand);

        Vec3 playerLookVector = player.getViewVector(1F);
        Vec3 playerEyePos = player.getEyePosition(1F);

        Vec3 castEndPos = playerEyePos.add(playerLookVector.normalize().multiply(50d, 50d, 50d));

        LogUtils.getLogger().info("look vector: " + playerLookVector);

        BlockPos blockLookingAt  = level.clip(new ClipContext(playerEyePos, castEndPos, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player)).getBlockPos();

        level.destroyBlock(blockLookingAt, true);

        return InteractionResult.SUCCESS_SERVER;
    }
}
