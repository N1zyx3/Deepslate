package net.n1zy.client.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

/**
 * Optional Mod Menu integration that opens the YACL screen.
 *
 * <p>This class is only loaded when Mod Menu is installed.
 */
public final class ModMenuIntegration implements ModMenuApi {
	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return DeepslateConfigScreen::create;
	}
}
