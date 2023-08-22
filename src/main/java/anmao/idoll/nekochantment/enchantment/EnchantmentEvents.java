package anmao.idoll.nekochantment.enchantment;

import anmao.idoll.nekochantment.NekoEnchantment;
import anmao.idoll.nekochantment.am._AM;
import anmao.idoll.nekochantment.am._AM_Color;
import anmao.idoll.nekochantment.am._AM_Constant;
import com.sun.jna.platform.win32.WinDef;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class EnchantmentEvents {
    @Mod.EventBusSubscriber(modid = NekoEnchantment.MODID)
    public static class FEE{
        private static final String TOOLTIPS_REFINE = "tooltips.nekoenchantment.refine";
        private static final int[] REFINE_COLOR = {15,14,6};
        private static final int[] KILLS_COLOR = {15,12,4};
        private static final int[] SOUL_COLOR = {15,7,8};
        private static final String TOOLTIPS_KILLS = "tooltips.nekoenchantment.kills";
        private static final String TOOLTIPS_SOULS = "tooltips.nekoenchantment.souls";
        @SubscribeEvent
        public static void onTooltip(ItemTooltipEvent event){
            @NotNull ItemStack item = event.getItemStack();
            int tmp;
            int colo = 15;
            if (item.getEnchantmentLevel(EnchantmentRegister.NEKO_KING.get()) > 0){
                if (item.getTag() != null) {
                    tmp = item.getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_REFINE);
                    if (tmp < 200) {
                        if (tmp < 20) {
                            colo = REFINE_COLOR[0];
                        }
                        if (tmp < 100 && tmp >= 50) {
                            colo = REFINE_COLOR[1];
                        }
                        if (tmp >= 100) {
                            colo = REFINE_COLOR[2];
                        }
                        MutableComponent st = Component.translatable(TOOLTIPS_REFINE).append(" : ").append(String.valueOf(tmp));
                        StringBuilder builder = new StringBuilder();
                        st.getVisualOrderText().accept((index,style,ch)->{
                            builder.append((char) ch);
                            return true;
                        });
                        String txt = builder.toString();
                        event.getToolTip().add(1,Component.literal(txt).withStyle(_AM.getColor(colo)));
                    }else {
                        MutableComponent str = Component.translatable(TOOLTIPS_REFINE).append(" : ").append(String.valueOf(tmp));
                        event.getToolTip().add(1, _AM_Color.RainbowTextColor(str.getString(), event.getEntity().level().getDayTime()));
                    }
                }

            }
            if (item.getEnchantmentLevel(EnchantmentRegister.NEKO_EMPEROR.get()) > 0){
                if (item.getTag() != null) {
                    tmp = item.getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_KILL);
                    if (tmp < 1000) {
                        if (tmp < 300) {
                            colo = KILLS_COLOR[0];
                        }
                        if (tmp < 700 && tmp >= 300) {
                            colo = KILLS_COLOR[1];
                        }
                        if ( tmp >= 700) {
                            colo = KILLS_COLOR[2];
                        }
                        event.getToolTip().add(2,Component.translatable(TOOLTIPS_KILLS)
                                .append(" : ")
                                .append(String.valueOf(tmp))
                                .withStyle(_AM.getColor(colo)));
                    }else {
                        MutableComponent str = Component.translatable(TOOLTIPS_KILLS).append(" : ").append(String.valueOf(tmp));
                        event.getToolTip().add(2, _AM_Color.RainbowTextColor(str.getString(), event.getEntity().level().getDayTime()));
                    }
                }
            }
            if (item.getEnchantmentLevel(EnchantmentRegister.NEKO_SOUL.get()) > 0){
                if (item.getTag() != null) {
                    tmp = item.getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_SOUL);
                    if (tmp < 10000) {
                        if (tmp < 3000) {
                            colo = SOUL_COLOR[0];
                        }
                        if (tmp < 6000 && tmp >= 3000) {
                            colo = SOUL_COLOR[1];
                        }
                        if ( tmp >= 6000) {
                            colo = SOUL_COLOR[2];
                        }
                        event.getToolTip().add(3,Component.translatable(TOOLTIPS_SOULS)
                                .append(" : ")
                                .append(String.valueOf(tmp))
                                .withStyle(_AM.getColor(colo)));
                    }else {
                        MutableComponent str = Component.translatable(TOOLTIPS_SOULS).append(" : ").append(String.valueOf(tmp));
                        event.getToolTip().add(3, _AM_Color.RainbowTextColor(str.getString(), event.getEntity().level().getDayTime()));
                    }
                }
            }
        }
    }
}
