package anmao.idoll.nekochantment.enchantment.nekoninja;

import anmao.idoll.nekochantment.am._AM;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class NekoNinja extends Enchantment {
    public NekoNinja(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostHurt(LivingEntity pTarget, Entity pAttacker, int pLevel) {
        if (!pTarget.level().isClientSide){
            pTarget.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,pLevel*20,pLevel));
            pTarget.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY,pLevel*20,pLevel));

        }
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
