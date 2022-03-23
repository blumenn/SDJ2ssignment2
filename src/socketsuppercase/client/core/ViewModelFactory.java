package socketsuppercase.client.core;

import socketsuppercase.client.views.log.LogViewModel;
import socketsuppercase.client.views.uppercase.UppercaseViewModel;

public class ViewModelFactory {

    private static ViewModelFactory instance=new ViewModelFactory();

    public static ViewModelFactory getInstance(){
        return instance;
    }
    private UppercaseViewModel uppercaseViewModel;
    private LogViewModel logViewModel;

    private ViewModelFactory() {
    }

    public UppercaseViewModel getUppercaseViewModel() {
        if (uppercaseViewModel == null)
            uppercaseViewModel = new UppercaseViewModel(ModelFactory.getInstance().getTextConverter());
        return uppercaseViewModel;
    }

    public LogViewModel getLogViewModel() {
        return (logViewModel = logViewModel == null ?
                new LogViewModel(ModelFactory.getInstance().getTextConverter()) :
                logViewModel);
    }
}
