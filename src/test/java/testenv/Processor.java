package testenv;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

import org.junit.runner.RunWith;

public class Processor extends AbstractProcessor {

	public static void setListener(ProcessorListener aListener) {
		Processor.listener = aListener;
	}

	private static ProcessorListener listener;

	private ProcessingEnvironment processingEnv;

	public static Processor INSTANCE;

	public Processor() {
		INSTANCE = this;
	}

	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		this.processingEnv = processingEnv;
		super.init(processingEnv);
	}

	public ProcessingEnvironment getProcessingEnv() {
		return processingEnv;
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		if (roundEnv.processingOver()) {
			return false;
		}
		if (listener != null) {
			listener.onInvoke(getProcessingEnv(), roundEnv);
		}
		return true;
	}

	@Override
	public Set<String> getSupportedAnnotationTypes() {
		return new HashSet<String>(Arrays.asList(RunWith.class.getCanonicalName()));
	}

	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latest();
	}

}