
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/interfaces/content_decryption_module.mojom
//

package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface ContentDecryptionModule extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends ContentDecryptionModule, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<ContentDecryptionModule, ContentDecryptionModule.Proxy> MANAGER = ContentDecryptionModule_Internal.MANAGER;


    void setClient(
org.chromium.mojo.bindings.AssociatedInterfaceNotSupported client);



    void initialize(
String keySystem, org.chromium.url.mojom.Origin securityOrigin, CdmConfig cdmConfig, 
InitializeResponse callback);

    interface InitializeResponse extends org.chromium.mojo.bindings.Callbacks.Callback3<CdmPromiseResult, Integer, Decryptor> { }



    void setServerCertificate(
byte[] certificateData, 
SetServerCertificateResponse callback);

    interface SetServerCertificateResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<CdmPromiseResult> { }



    void getStatusForPolicy(
int minHdcpVersion, 
GetStatusForPolicyResponse callback);

    interface GetStatusForPolicyResponse extends org.chromium.mojo.bindings.Callbacks.Callback2<CdmPromiseResult, Integer> { }



    void createSessionAndGenerateRequest(
int sessionType, int initDataType, byte[] initData, 
CreateSessionAndGenerateRequestResponse callback);

    interface CreateSessionAndGenerateRequestResponse extends org.chromium.mojo.bindings.Callbacks.Callback2<CdmPromiseResult, String> { }



    void loadSession(
int sessionType, String sessionId, 
LoadSessionResponse callback);

    interface LoadSessionResponse extends org.chromium.mojo.bindings.Callbacks.Callback2<CdmPromiseResult, String> { }



    void updateSession(
String sessionId, byte[] response, 
UpdateSessionResponse callback);

    interface UpdateSessionResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<CdmPromiseResult> { }



    void closeSession(
String sessionId, 
CloseSessionResponse callback);

    interface CloseSessionResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<CdmPromiseResult> { }



    void removeSession(
String sessionId, 
RemoveSessionResponse callback);

    interface RemoveSessionResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<CdmPromiseResult> { }


}
