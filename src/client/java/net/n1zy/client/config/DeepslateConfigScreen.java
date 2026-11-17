package net.n1zy.client.config;

import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import net.n1zy.config.DeepslateConfig;

/**
 * Builds the YACL config screen for {@link DeepslateConfig}.
 *
 * <p>A fresh screen is generated on every call, as required by YACL.
 */
public final class DeepslateConfigScreen {
	private DeepslateConfigScreen() {
	}

	public static Screen create(Screen parent) {
		DeepslateConfig config = DeepslateConfig.get();
		DeepslateConfig defaults = DeepslateConfig.HANDLER.defaults();

		return YetAnotherConfigLib.createBuilder()
				.title(Component.translatable("deepslate.config.title"))
				.category(ConfigCategory.createBuilder()
						.name(Component.translatable("deepslate.config.category.general"))
						.option(Option.<Boolean>createBuilder()
								.name(Component.translatable("deepslate.config.option.enabled"))
								.description(OptionDescription.of(
										Component.translatable("deepslate.config.option.enabled.tooltip")))
								.binding(defaults.enabled, () -> config.enabled, value -> config.enabled = value)
								.controller(TickBoxControllerBuilder::create)
								.build())
						.option(Option.<Boolean>createBuilder()
								.name(Component.translatable("deepslate.config.option.debug_logging"))
								.description(OptionDescription.of(
										Component.translatable("deepslate.config.option.debug_logging.tooltip")))
								.binding(defaults.debugLogging, () -> config.debugLogging,
										value -> config.debugLogging = value)
								.controller(TickBoxControllerBuilder::create)
								.build())
						.build())
				.save(DeepslateConfig.HANDLER::save)
				.build()
				.generateScreen(parent);
	}
}
