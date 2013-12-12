package com.jacky.utilities;

public class MathTool {
	public static Orientation_Sensor getOrientationSensor(float inclination,float rotation){
		Orientation_Sensor mOrientation_Sensor=Orientation_Sensor.DEGREE_ERROR;
		float inaccuracy = 40;
		float inaccuracy_horizontal = 50;
		float boundary = 0;
		if(inaccuracy >0 && inaccuracy <90){
			if(inclination>0){
				boundary = 90;
				if(boundary-inaccuracy<=inclination && inclination<= boundary+inaccuracy){
					mOrientation_Sensor = Orientation_Sensor.DEGREE_180;
				}
			}else{
				boundary = -90;
				if(boundary-inaccuracy<=inclination && inclination<= boundary+inaccuracy){
					mOrientation_Sensor = Orientation_Sensor.DEGREE_0;
				}
			}
			if(rotation>0){
				boundary = 90;
				if(boundary-inaccuracy_horizontal<=rotation && rotation<= boundary+inaccuracy_horizontal){
					mOrientation_Sensor = Orientation_Sensor.DEGREE_270;
				}
			}else{
				boundary = -90;
				if(boundary-inaccuracy_horizontal<=rotation && rotation<= boundary+inaccuracy_horizontal){
					mOrientation_Sensor = Orientation_Sensor.DEGREE_90;
				}
			}
		}
		return mOrientation_Sensor;
	}
	public enum Orientation_Sensor {
		DEGREE_0("DEGREE_0"),
		DEGREE_90("DEGREE_90"),
		DEGREE_180("DEGREE_180"),
		DEGREE_270("DEGREE_270"),
		DEGREE_ERROR("DEGREE_ERROR"),
		;
		private String TypeCode;
		
		/**
		 * 构造一个具有指定字符串的枚举值
		 * @param inTypeCode
		 */
		private Orientation_Sensor(String inTypecode){
			this.TypeCode=inTypecode;
		}
		
		public String toString(){
			return TypeCode;
		}
		
		/**
		 * 根据指定的字符串获取相应的枚举值
		 * @param inActionCode
		 * @return
		 */
		public static Orientation_Sensor getMsgType(String inTypeCode){
			for(Orientation_Sensor type:Orientation_Sensor.values()){
				if(type.TypeCode.equals(inTypeCode))
					return type;
			}
			return null;
		}
	}
}
