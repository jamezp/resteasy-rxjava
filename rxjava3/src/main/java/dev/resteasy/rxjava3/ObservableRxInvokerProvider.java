/*
 * JBoss, Home of Professional Open Source.
 *
 * Copyright 2022 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.resteasy.rxjava3;

import java.util.concurrent.ExecutorService;

import javax.ws.rs.client.RxInvokerProvider;
import javax.ws.rs.client.SyncInvoker;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.ext.Provider;

@Provider
public class ObservableRxInvokerProvider implements RxInvokerProvider<ObservableRxInvoker> {
    WebTarget target;

    @Override
    public boolean isProviderFor(Class<?> clazz) {
        return ObservableRxInvoker.class.equals(clazz);
    }

    @Override
    public ObservableRxInvoker getRxInvoker(SyncInvoker syncInvoker, ExecutorService executorService) {
        return new ObservableRxInvokerImpl(syncInvoker, executorService);
    }

    public WebTarget getTarget() {
        return target;
    }

    public void setTarget(WebTarget target) {
        this.target = target;
    }
}
