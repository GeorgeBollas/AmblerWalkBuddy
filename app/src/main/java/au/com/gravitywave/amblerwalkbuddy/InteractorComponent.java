package au.com.gravitywave.amblerwalkbuddy;

import javax.inject.Singleton;

import au.com.gravitywave.amblerwalkbuddy.Interactors.RequestsInteractor;
import au.com.gravitywave.amblerwalkbuddy.repositories.RequestRepository;
import dagger.Component;

/**
 * Created by georg on 9/07/2017.
 */

@Singleton
@Component(
        modules = { InteractorModule.class }
)
public interface InteractorComponent {
    RequestsInteractor provideRequestInteractor();
}
