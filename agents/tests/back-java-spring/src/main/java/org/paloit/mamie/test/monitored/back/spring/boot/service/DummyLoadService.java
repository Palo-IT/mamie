package org.paloit.mamie.test.monitored.back.spring.boot.service;

import com.martensigwart.fakeload.*;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class DummyLoadService implements ILoadService{

    @Override
    public void doFullCPULoad(long durationSeconds) {
        final FakeLoad fakeload = FakeLoads.create()
                .lasting(durationSeconds, TimeUnit.SECONDS)
                .withCpu(100);

        final FakeLoadExecutor executor = FakeLoadExecutors.newDefaultExecutor();
        executor.execute(fakeload);
    }
}
