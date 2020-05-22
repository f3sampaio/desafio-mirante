package br.net.mirante.enums;

public enum ProfileTypesEnum {
	
	ADMIN(1), MANAGER(2);
	
	public int type;
	
    ProfileTypesEnum(int i) {
        this.type = i;
    }

}
