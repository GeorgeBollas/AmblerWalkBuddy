package au.com.gravitywave.amblerwalkbuddy;

import javax.inject.Singleton;

import au.com.gravitywave.amblerwalkbuddy.Interactors.RequestsInteractor;
import au.com.gravitywave.amblerwalkbuddy.repositories.RequestRepository;
import dagger.Module;
import dagger.Provides;

/**
 * Created by georg on 9/07/2017.
 */

@Module
public class InteractorModule {

    @Provides @Singleton RequestRepository ProvideRequestRepository(){
        return new RequestRepository();
    }

    @Provides @Singleton
    RequestsInteractor proviedRequestInteractor(){
        return new RequestsInteractor(new RequestRepository());
    }
}
