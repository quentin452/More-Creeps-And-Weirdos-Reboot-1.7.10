package fr.elias.morecreeps.common.items;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import fr.elias.morecreeps.common.entity.CREEPSEntityShrink;

public class CREEPSItemShrinkRay extends Item {

    public static Random rand = new Random();

    public CREEPSItemShrinkRay() {
        super();
        maxStackSize = 1;
        setMaxDamage(128);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        world
            .playSoundAtEntity(entityplayer, "morecreeps:shrinkray", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote) {
            double d = -MathHelper.sin((entityplayer.rotationYaw * (float) Math.PI) / 180F);
            double d1 = MathHelper.cos((entityplayer.rotationYaw * (float) Math.PI) / 180F);
            double d2 = 0.0D;
            double d3 = 0.0D;
            double d4 = 0.012999999999999999D;
            double d5 = 4D;
            CREEPSEntityShrink creepsentityshrink = new CREEPSEntityShrink(world, entityplayer, 0.0F);

            if (creepsentityshrink != null) {
                itemstack.damageItem(1, entityplayer);
                world.spawnEntityInWorld(creepsentityshrink);
            }
        }

        return itemstack;
    }
}
