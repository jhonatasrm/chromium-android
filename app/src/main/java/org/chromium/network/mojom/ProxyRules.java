
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/proxy_config.mojom
//

package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public final class ProxyRules extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 64;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(64, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public ProxyBypassRules bypassRules;
    public boolean reverseBypass;
    public int type;
    public ProxyList singleProxies;
    public ProxyList proxiesForHttp;
    public ProxyList proxiesForHttps;
    public ProxyList proxiesForFtp;
    public ProxyList fallbackProxies;

    private ProxyRules(int version) {
        super(STRUCT_SIZE, version);
    }

    public ProxyRules() {
        this(0);
    }

    public static ProxyRules deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static ProxyRules deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static ProxyRules decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        ProxyRules result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new ProxyRules(elementsOrVersion);
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                result.bypassRules = ProxyBypassRules.decode(decoder1);
                }
                {
                    
                result.reverseBypass = decoder0.readBoolean(16, 0);
                }
                {
                    
                result.type = decoder0.readInt(20);
                    ProxyRulesType.validate(result.type);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, false);
                result.singleProxies = ProxyList.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(32, false);
                result.proxiesForHttp = ProxyList.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(40, false);
                result.proxiesForHttps = ProxyList.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(48, false);
                result.proxiesForFtp = ProxyList.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(56, false);
                result.fallbackProxies = ProxyList.decode(decoder1);
                }

        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
        org.chromium.mojo.bindings.Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        
        encoder0.encode(this.bypassRules, 8, false);
        
        encoder0.encode(this.reverseBypass, 16, 0);
        
        encoder0.encode(this.type, 20);
        
        encoder0.encode(this.singleProxies, 24, false);
        
        encoder0.encode(this.proxiesForHttp, 32, false);
        
        encoder0.encode(this.proxiesForHttps, 40, false);
        
        encoder0.encode(this.proxiesForFtp, 48, false);
        
        encoder0.encode(this.fallbackProxies, 56, false);
    }
}