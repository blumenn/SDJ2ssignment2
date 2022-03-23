package socketsuppercase.client.core;


import socketsuppercase.client.model.TextConverter;
import socketsuppercase.client.model.TextConverterManager;

public class ModelFactory {

    private static ModelFactory instance = new ModelFactory();
    public static ModelFactory getInstance(){
        return instance;
    }
    private TextConverter textConverter;

    private ModelFactory() {
    }

    public TextConverter getTextConverter() {
        if(textConverter == null)
            textConverter = new TextConverterManager(ClientFactory.getInstance().getClient());
        return textConverter;
    }
}


