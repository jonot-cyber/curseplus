package com.github.jonotcyber.curseplus.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Inject(at = @At("HEAD"), method = "isDamageable()Z", cancellable = true)
    public void isDamageable(CallbackInfoReturnable<Boolean> cir) {
	cir.setReturnValue(!EnchantmentHelper.hasBindingCurse((ItemStack)((Object)this)));
    }
}
