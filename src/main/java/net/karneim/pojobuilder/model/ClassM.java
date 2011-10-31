package net.karneim.pojobuilder.model;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ClassM {
	private final TypeM type;
	private final TypeM superType;
	private Date created;

	public ClassM(TypeM aType, TypeM aSuperType) {
		this.type = aType;
		this.superType = aSuperType;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getCreated() {
		return created;
	}

	public String getCreatedString() {
		return DateFormat.getDateInstance().format(created);
	}

	public TypeM getType() {
		return type;
	}

	public TypeM getSuperType() {
		return superType;
	}

	public final Collection<String> getImportTypes() {
		Set<String> result = new HashSet<String>();
		addToImportTypes(result);
		return result;
	}

	public void addToImportTypes(Set<String> result) {
		superType.addToImportTypes(result);
	}

	@Override
	public String toString() {
		return "ClassM [type=" + type + ", superType=" + superType
				+ ", created=" + created + "]";
	}

}