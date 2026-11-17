package net.n1zy.client.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

/**
 * Mod Menu integration that opens the YACL screen from the mod's config button.
 *
 * <p>Mod Menu is a required dependency, so this entrypoint is always present on the client.
 */
public final class ModMenuIntegration implements ModMenuApi {
	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return DeepslateConfigScreen::create;
	}
}
