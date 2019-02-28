package design.mode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 代理模式例子
 * @author daxing.cao create by 2018/08/07
 * @version 1.0
 *
 */
public class ProxyExample {
	
	public static void main(String[] args) {
		System.out.println("==================================");
		UserDaoImpl user = new UserDaoImpl();
		UserDao userDaoImpl = (UserDaoImpl) new ProxyFactory(user).getProxyInstance();
		userDaoImpl.say();
		UserDaoImpl userDao = (UserDaoImpl) new ProxyFactoryTwo(user).getProxyInstance();
		userDao.save();
	}

}
/**************必须实现接口的动态代理,基于jdk实现动态代理*****************/
interface UserDao{
	void save();
	void say();
}

class UserDaoImpl implements UserDao{

	@Override
	public void save() {
		System.out.println("保存数据成功...");
	}

	@Override
	public void say() {
		System.out.println("i am target object");
	}
}

class ProxyFactory implements InvocationHandler{
	private Object target;
	
	ProxyFactory(Object target) {
		this.target = target;
	}
	
	Object getProxyInstance() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("事务开始");
		Object invoke = method.invoke(target, args);
		System.out.println("事务结束");
		return invoke;
	}
}

/*****************不需要实现接口的动态代理,基于cglib实现动态代理********************/
class ProxyFactoryTwo implements MethodInterceptor {
	
	private Object target;
	
	ProxyFactoryTwo(Object target) {
		this.target = target;
	}
	
	Object getProxyInstance() {
		Enhancer en = new Enhancer();
		en.setSuperclass(target.getClass());
		en.setCallback(this);
		return en.create();
	}

	@Override
	public Object intercept(Object arg0, Method method, Object[] arg2, MethodProxy methodProxy) throws Throwable {
		System.out.println("保存数据开始");
		Object invoke = method.invoke(target,arg2);
		System.out.println("保存数据结束");
		return invoke;
	}
	
}
