package design.mode;

/**
 * 工厂模式例子
 * @author daxing.cao create by 2018/08/06
 * @version 1.0
 * 
 */
public class FactoryExample {
	
	public static void main(String[] args) {
		Teacher courseTeacher = TeacherFactory.getCourseTeacher(MathTeacher.class);
		courseTeacher.say();
		Teacher courseTeacher2 = TeacherFactory.getCourseTeacher(EnglishTeacher.class);
		if(courseTeacher instanceof MathTeacher) {
			System.out.println("yes,you're right!");
		}
		courseTeacher2.say();
	}

}

interface Teacher{	
	void say();	
}

class MathTeacher implements Teacher{

	@Override
	public void say() {
		System.out.println("I'm MathTeacher!");
	}
	
}

class EnglishTeacher implements Teacher{

	@Override
	public void say() {
		System.out.println("I'm EnglishTeacher!");
	}
	
}

class TeacherFactory {
	
	public static Teacher getCourseTeacher(Class<? extends Teacher> teacherType) {
		try {
			return teacherType.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}