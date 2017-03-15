package com.clowcadia.test;

import com.clowcadia.test.entities.Test;
import com.clowcadia.test.render.RenderEntityTest;
import com.clowcadia.test.render.RenderTestFactory;
import com.clowcadia.test.utils.Utils;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class TestModelManager {
	
	public static void registerAllModels(){
		Utils.getLogger().info("TestModelManager: registerAllModels");
		
		registerMobModels();
	}
	
	private static void registerMobModels(){
		Utils.getLogger().info("TestModelManager: registerMobModels");
		
		registerMobModel(Test.class, RenderTestFactory.INSTANCE);
	}
	

	private static <T extends Entity> void registerMobModel(Class<T> entity, IRenderFactory<? super T> renderFactory)
	{
		Utils.getLogger().info("TestModelManager: registerMobModel");
		
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory);
	}

}