
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/proxy_config_with_annotation.mojom
//

package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface ProxyConfigClient extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends ProxyConfigClient, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<ProxyConfigClient, ProxyConfigClient.Proxy> MANAGER = ProxyConfigClient_Internal.MANAGER;


    void onProxyConfigUpdated(
ProxyConfigWithAnnotation proxyConfig);


}
