package anmao.idoll.nekochantment.enchantment.nekonight;

import anmao.idoll.nekochantment.enchantment.nekoday.NekoDay;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.WorldLoader;
import net.minecraft.server.WorldStem;
import net.minecraft.server.gui.MinecraftServerGui;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.util.List;

public class NekoNight extends Enchantment {
    //public ServerLevel SERVERLEVEL = null;
    public NekoNight(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }
    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        //this.SERVERLEVEL = (ServerLevel) pAttacker.level();
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
    /*
    @Override
    public float getDamageBonus(int level, MobType mobType, ItemStack enchantedItem) {
        PlayerList pl = ServerLifecycleHooks.getCurrentServer().getPlayerList();
        int daytime = -1;
        if (pl.getPlayerCount() > 0){
            List<ServerPlayer> players = pl.getPlayers();
            for (ServerPlayer serverPlayer : players){
                if (serverPlayer != null){
                    daytime = (int) serverPlayer.level().getDayTime();
                }
            }
            if (daytime == -1){return 0;}
            float damage = 1 + level * 0.5F;
            if (daytime < 7200 || daytime > 22800){
                return damage;
            }
            return -damage;
        }
        return 0;
    }

     */

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return !(pOther instanceof NekoDay);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }
}
