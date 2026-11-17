package net.n1zy.config;

import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;

import net.fabricmc.loader.api.FabricLoader;

import net.n1zy.Deepslate;

/**
 * Persistent configuration of the mod, stored and loaded by YACL.
 *
 * <p>Every field annotated with {@link SerialEntry} is written to
 * {@code config/deepslate.json5}. The values are exposed in game through the
 * YACL screen built in {@code net.n1zy.client.config.DeepslateConfigScreen}.
 */
public final class DeepslateConfig {
	public static final ConfigClassHandler<DeepslateConfig> HANDLER = ConfigClassHandler
			.createBuilder(DeepslateConfig.class)
			.id(Deepslate.id("config"))
			.serializer(config -> GsonConfigSerializerBuilder.create(config)
					.setPath(FabricLoader.getInstance().getConfigDir().resolve(Deepslate.MOD_ID + ".json5"))
					.setJson5(true)
					.build())
			.build();

	@SerialEntry(comment = "Master switch for all Deepslate features.")
	public boolean enabled = true;

	@SerialEntry(comment = "Write extra diagnostic output to the log.")
	public boolean debugLogging = false;

	public static DeepslateConfig get() {
		return HANDLER.instance();
	}
}
