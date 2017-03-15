package com.clowcadia.test.ai;

import com.clowcadia.test.entities.Test;
import com.clowcadia.test.utils.Utils;

import io.netty.handler.codec.serialization.ObjectEncoderOutputStream;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.world.World;

public class TaskAIGoTo extends EntityAIBase{
	
	private final Test test;
	World world;
    private final double goToSpeed;
    private final PathNavigate testPathFinder;
    
    public TaskAIGoTo(Test test, double goToSpeed) {
    	Utils.getLogger().info("TaskAIGoTo: Constructor");
		this.test = test;
		this.world = test.world;
		this.goToSpeed = goToSpeed;
		this.testPathFinder = test.getNavigator();
		this.setMutexBits(3);
    }
		
	@Override
	public boolean shouldExecute() {
		Utils.getLogger().info("TaskAIGoTo: shouldExecute");
		EntityLivingBase entitylivingbase = this.test.getOwner();
		if (entitylivingbase == null)
        {
			Utils.getLogger().info("TaskAIGoTo: shouldExecute : false");
            return false;
        }else {
        	Utils.getLogger().info("TaskAIGoTo: shouldExecute: true");
        	this.test.getNavigator().tryMoveToXYZ(29, 62, 265, goToSpeed);
        	return true;
        }
	}
	
	public boolean continueExecuting(){
		Utils.getLogger().info("TaskAIGoTo: continueExecute");
		boolean output =!this.test.getNavigator().noPath();
		Utils.getLogger().info("TaskAIGoTo: continueExecute: "+output+" distance: "+test.getDistance(29, 62, 265));
		return !this.test.getNavigator().noPath();		
    }
	
	 //public void updateTask(){
		// Utils.getLogger().info("TaskAIGoTo: updateTask");
		 //if(test.getDistance(29, 62, 265)>2){
			// Utils.getLogger().info("TaskAIGoTo: updateTask: true");
			 
		// }
	// }

}