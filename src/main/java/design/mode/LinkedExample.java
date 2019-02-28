package design.mode;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * 责任链模式
 * @author Administrator
 *
 */
public class LinkedExample {
	
	static class HandlerA extends Handler{
		@Override
		protected void process() {
			System.out.println("Handler a");
		}
	}
	static class HandlerB extends Handler{
		@Override
		protected void process() {
			System.out.println("Handler b");
		}
	}
	static class HandlerC extends Handler{
		@Override
		protected void process() {
			System.out.println("Handler c");
		}
	}
	public static void main(String[] args) throws Exception {
		List<Handler> asList = Arrays.asList(new HandlerB(),new HandlerA(),new HandlerC());
		Chainner chain = new Chainner(asList);
		chain.execute();
		Test newInstance = Test.class.newInstance();
		Handler handler = newInstance.getHandler(HandlerA.class);
		System.out.println(handler);
	}

}

class Chainner{
	
	private int index = 0;
	
	private List<Handler> handlerList;
	
	public Chainner(List<Handler> list) {
		this.handlerList = list;
	}
	
	public void execute() {
		if(index >= handlerList.size()) {
			return ;
		}
		handlerList.get(index++).execute(this);
	}
	
}

abstract class Handler implements Serializable{
	
	public void execute(Chainner chainner) {
		process();
		chainner.execute();
	}
	
	protected abstract void process();
	
}

class Test{
	private Path path = Paths.get("d:/mavenproject", "data");
	
	private Integer code = 1024;
	
	public void test() {
		System.out.println(path.toString());
	}
	
	public Path getPath(Class<?> type) {
		return path.resolve(type.getSimpleName());
	}
	
	public Path getSinglePath(Class<?> type, Integer id) {
		return getPath(type).resolve(String.format("%s.bin", id));
	}
	
	public <T extends Handler> T getHandler(Class<?> type) throws ClassNotFoundException, IOException {
		Path singlePath = getSinglePath(type, code);
		try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(singlePath))) {
			return (T) ois.readObject();
		}
	}
	
	public void saveHandler(Handler handler) throws IOException {
		Path singlePath = getSinglePath(handler.getClass(), code);
		if(!Files.exists(singlePath)) {
			Files.createFile(singlePath);
		}
		try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(singlePath))){
			oos.writeObject(handler);
		}
	}
	
}