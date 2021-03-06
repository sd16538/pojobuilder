package net.karneim.pojobuilder.analysis;

import java.util.Map;

import net.karneim.pojobuilder.GeneratePojoBuilder;

public class Directives {
  private boolean generateCopyMethod = false;
  private String copyMethodName = null;
  private String intoPackage = GeneratePojoBuilder.DEFAULT_PACKAGE;
  private String builderName = GeneratePojoBuilder.DEFAULT_NAME;
  private String baseclassName = Object.class.getName();
  private String builderInterfaceName = Void.class.getName();
  private boolean generateBuilderProperties = false;
  private boolean generationGap = false;
  private String setterNamePattern = GeneratePojoBuilder.DEFAULT_SETTER_NAME;
  private String staticFactoryMethod = GeneratePojoBuilder.DEFAULT_FACTORY_METHOD;
  private String validatorClassname = Void.class.getName();
  private String optionalClassname = Void.class.getName();

  public Directives(Map<String, Object> valueMap) {
    if (valueMap == null) {
      throw new NullPointerException("valueMap must not be null!");
    }
    baseclassName = (String) valueMap.get("withBaseclass");
    builderInterfaceName = (String) valueMap.get("withBuilderInterface");
    generateBuilderProperties = (Boolean) valueMap.get("withBuilderProperties");
    builderName = (String) valueMap.get("withName");
    intoPackage = (String) valueMap.get("intoPackage");
    generationGap = (Boolean) valueMap.get("withGenerationGap");
    generateCopyMethod = (Boolean) valueMap.get("withCopyMethod");
    if (generateCopyMethod) {
      copyMethodName = "copy"; // TODO make configurable in annotation!
    }
    setterNamePattern = (String) valueMap.get("withSetterNamePattern");
    staticFactoryMethod = (String) valueMap.get("withFactoryMethod");
    validatorClassname = (String) valueMap.get("withValidator");
    optionalClassname = (String) valueMap.get("withOptionalProperties");
  }

  public boolean isGenerateCopyMethod() {
    return generateCopyMethod;
  }

  public void setGenerateCopyMethod(boolean generateCopyMethod) {
    this.generateCopyMethod = generateCopyMethod;
  }

  public String getCopyMethodName() {
    return copyMethodName;
  }

  public void setCopyMethodName(String copyMethodName) {
    this.copyMethodName = copyMethodName;
  }

  public String getValidatorClassname() {
    return validatorClassname;
  }

  public void setValidatorClassname(String validatorClassname) {
    this.validatorClassname = validatorClassname;
  }

  public boolean isGenerationGap() {
    return generationGap;
  }

  public boolean isGenerateBuilderProperties() {
    return generateBuilderProperties;
  }

  public void setGenerateBuilderProperties(boolean generateBuilderProperties) {
    this.generateBuilderProperties = generateBuilderProperties;
  }

  public void setGenerationGap(boolean generationGap) {
    this.generationGap = generationGap;
  }

  public void setIntoPackage(String intoPackage) {
    if (intoPackage == null) {
      throw new IllegalArgumentException("intoPackage==null");
    }
    if (intoPackage.startsWith("java.")) {
      throw new AnalysisException("Value for attribute 'intoPackage' must not start with 'java.'");
    }
    this.intoPackage = intoPackage;
  }

  public String getIntoPackage() {
    return intoPackage;
  }

  public String getBuilderName() {
    return builderName;
  }

  public void setBuilderName(String builderName) {
    if (builderName == null || builderName.trim().isEmpty()) {
      throw new AnalysisException("Value for attribute 'withName' must not be empty.");
    }
    this.builderName = builderName;
  }

  public void setBaseclassName(String baseclassName) {
    this.baseclassName = baseclassName;
  }

  public String getBaseclassName() {
    return baseclassName;
  }

  public String getBuilderInterfaceName() {
    return builderInterfaceName;
  }

  public void setBuilderInterfaceName(String builderInterfaceName) {
    this.builderInterfaceName = builderInterfaceName;
  }

  public String getSetterNamePattern() {
    return setterNamePattern;
  }

  public void setSetterNamePattern(String pattern) {
    this.setterNamePattern = pattern;
  }

  public String getOptionalClassname() {
    return optionalClassname;
  }

  public void setOptionalClassname(String optionalClassname) {
    this.optionalClassname = optionalClassname;
  }

  public String getStaticFactoryMethod() {
    return staticFactoryMethod;
  }

  public void setStaticFactoryMethod(String staticFactoryMethod) {
    this.staticFactoryMethod = staticFactoryMethod;
  }

  @Override
  public String toString() {
    return "Directives [generateCopyMethod=" + generateCopyMethod + ", copyMethodName="
        + copyMethodName + ", intoPackage=" + intoPackage + ", builderName=" + builderName
        + ", baseclassName=" + baseclassName + ", builderInterfaceName=" + builderInterfaceName
        + ", generateBuilderProperties=" + generateBuilderProperties + ", generationGap="
        + generationGap + ", setterNamePattern=" + setterNamePattern + ", validatorClassname="
        + validatorClassname + ", staticFactoryMethod=" + staticFactoryMethod
        + ", optionalClassname=" + optionalClassname + "]";
  }

}
