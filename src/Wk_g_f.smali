==  LWk/g;->f(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V
   0000: move-object/from16 v1, v16
   0002: move-object/from16 v0, v17
   0004: move-object/from16 v5, v18
   0006: move-object/from16 v3, v19
   0008: iget-object v2, v1, LWk/g;->b:Landroid/content/Context;
   000a: const-string v4, 'body'
   000c: invoke-static {v5,v4} Lkotlin/jvm/internal/k;->i(Ljava/lang/Object;Ljava/lang/String;)V
   000f: const-string v4, 'title'
   0011: invoke-static {v3,v4} Lkotlin/jvm/internal/k;->i(Ljava/lang/Object;Ljava/lang/String;)V
   0014: const-string v4, 'push_id'
   0016: const-string v6, ''
   0018: if-eqz v0, -> 0020
   001a: invoke-virtual {v0,v4} Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
   001d: move-result-object v7
   001e: if-nez v7, -> 0021
   0020: move-object v7, v6
   0021: invoke-virtual {v3,v6} Ljava/lang/Object;->equals(Ljava/lang/Object;)Z
   0024: move-result v8
   0025: const/4 v10, 0
   0026: if-nez v8, -> 0034
   0028: invoke-virtual {v3,v7} Ljava/lang/Object;->equals(Ljava/lang/Object;)Z
   002b: move-result v7
   002c: if-eqz v7, -> 0034
   002e: new-instance v7, Lorg/json/JSONObject;
   0030: invoke-direct {v7,v5} Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
   0033: goto -> 0035
   0034: move-object v7, v10
   0035: const-string v8, 'callback_url'
   0037: const-string v9, 'campaign'
   0039: const-string v11, 'action'
   003b: if-eqz v7, -> 007d
   003d: invoke-virtual {v7,v8} Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
   0040: move-result-object v12
   0041: invoke-static {v12,v6} Lkotlin/jvm/internal/k;->d(Ljava/lang/Object;Ljava/lang/Object;)Z
   0044: move-result v12
   0045: if-nez v12, -> 007d
   0047: invoke-virtual {v7,v9} Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
   004a: move-result-object v12
   004b: invoke-static {v12,v6} Lkotlin/jvm/internal/k;->d(Ljava/lang/Object;Ljava/lang/Object;)Z
   004e: move-result v12
   004f: if-nez v12, -> 007d
   0051: invoke-virtual {v7,v11} Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
   0054: move-result-object v12
   0055: invoke-static {v12,v6} Lkotlin/jvm/internal/k;->d(Ljava/lang/Object;Ljava/lang/Object;)Z
   0058: move-result v12
   0059: if-nez v12, -> 007d
   005b: invoke-virtual {v7,v9} Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
   005e: move-result-object v0
   005f: new-instance v3, Landroid/content/Intent;
   0061: invoke-direct {v3} Landroid/content/Intent;-><init>()V
   0064: invoke-virtual {v7,v11} Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
   0067: move-result-object v4
   0068: invoke-virtual {v3,v2,v4} Landroid/content/Intent;->setClassName(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
   006b: move-result-object v3
   006c: invoke-static {v0} Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
   006f: move-result-object v4
   0070: invoke-virtual {v3,v4} Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;
   0073: move-result-object v3
   0074: invoke-virtual {v3,v0,v0} Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
   0077: move-result-object v0
   0078: invoke-virtual {v2,v0} Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V
   007b: goto/16 -> 01e2
   007d: if-eqz v0, -> 0085
   007f: invoke-virtual {v0,v11} Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
   0082: move-result-object v2
   0083: if-nez v2, -> 0086
   0085: move-object v2, v6
   0086: invoke-static {v3} LuG/o;->J(Ljava/lang/CharSequence;)Z
   0089: move-result v7
   008a: const-string v12, 'silent'
   008c: if-eqz v7, -> 00a9
   008e: invoke-virtual {v2,v12} Ljava/lang/Object;->equals(Ljava/lang/Object;)Z
   0091: move-result v2
   0092: if-nez v2, -> 00a9
   0094: new-instance v0, LRu/f;
   0096: const/16 v2, 19
   0098: invoke-direct {v0,v2} LRu/f;-><init>(I)V
   009b: sget-object v2, LLm/a;->a:LNm/g;
   009d: if-eqz v2, -> 00a3
   009f: invoke-virtual {v2,v0} LNm/g;->a(LYE/a;)V
   00a2: return-void
   00a3: const-string v0, 'instance'
   00a5: invoke-static {v0} Lkotlin/jvm/internal/k;->r(Ljava/lang/String;)V
   00a8: throw v10
   00a9: if-eqz v0, -> 00b1
   00ab: invoke-virtual {v0,v11} Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
   00ae: move-result-object v2
   00af: if-nez v2, -> 00b2
   00b1: move-object v2, v6
   00b2: if-eqz v0, -> 00ba
   00b4: invoke-virtual {v0,v4} Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
   00b7: move-result-object v4
   00b8: if-nez v4, -> 00bb
   00ba: move-object v4, v6
   00bb: if-eqz v0, -> 00c2
   00bd: invoke-virtual {v0,v8} Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
   00c0: move-result-object v7
   00c1: goto -> 00c3
   00c2: move-object v7, v10
   00c3: if-eqz v0, -> 00d9
   00c5: const-string v8, 'param'
   00c7: invoke-virtual {v0,v8,v6} Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
   00ca: move-result-object v0
   00cb: if-eqz v0, -> 00d9
   00cd: new-instance v8, Lorg/json/JSONObject;
   00cf: invoke-direct {v8,v0} Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
   00d2: goto -> 00da
   00d3: move-exception v0
   00d4: const/16 v8, 11
   00d6: invoke-static {v10,v8,v10,v0} LWC/f;->b(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
   00d9: move-object v8, v10
   00da: if-eqz v8, -> 00e3
   00dc: const-string v0, 'message_id'
   00de: invoke-virtual {v8,v0} Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
   00e1: move-result-object v0
   00e2: goto -> 00e4
   00e3: move-object v0, v10
   00e4: invoke-virtual {v4} Ljava/lang/String;->length()I
   00e7: move-result v11
   00e8: if-nez v11, -> 0107
   00ea: if-eqz v0, -> 00f5
   00ec: invoke-static {v0} LuG/o;->J(Ljava/lang/CharSequence;)Z
   00ef: move-result v4
   00f0: if-eqz v4, -> 00f3
   00f2: goto -> 00f5
   00f3: move-object v4, v0
   00f4: goto -> 0107
   00f5: new-instance v4, Ljava/util/Date;
   00f7: invoke-direct {v4} Ljava/util/Date;-><init>()V
   00fa: invoke-virtual {v4} Ljava/util/Date;->getTime()J
   00fd: move-result-wide v13
   00fe: const v4, 2147483647
   0101: int-to-long v10, v4
   0102: rem-long/2addr v13, v10
   0103: invoke-static {v13,v14} Ljava/lang/String;->valueOf(J)Ljava/lang/String;
   0106: move-result-object v4
   0107: if-eqz v8, -> 010e
   0109: invoke-virtual {v8,v9} Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
   010c: move-result-object v9
   010d: goto -> 010f
   010e: const/4 v9, 0
   010f: if-eqz v8, -> 0118
   0111: const-string v10, 'id'
   0113: invoke-virtual {v8,v10} Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
   0116: move-result-object v10
   0117: goto -> 0119
   0118: const/4 v10, 0
   0119: if-eqz v8, -> 0122
   011b: const-string v11, 'mng_token'
   011d: invoke-virtual {v8,v11} Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
   0120: move-result-object v11
   0121: goto -> 0123
   0122: const/4 v11, 0
   0123: if-eqz v8, -> 012c
   0125: const-string v13, 'censored'
   0127: invoke-virtual {v8,v13} Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z
   012a: move-result v13
   012b: goto -> 012d
   012c: const/4 v13, 0
   012d: if-eqz v8, -> 0136
   012f: const-string v14, 'dynamic_link'
   0131: invoke-virtual {v8,v14} Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
   0134: move-result-object v14
   0135: goto -> 0137
   0136: const/4 v14, 0
   0137: if-eqz v8, -> 0140
   0139: const-string v15, 'call_public_id'
   013b: invoke-virtual {v8,v15} Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
   013e: move-result-object v15
   013f: goto -> 0141
   0140: const/4 v15, 0
   0141: const-string v8, 'notificationId'
   0143: invoke-static {v4,v8} Lkotlin/jvm/internal/k;->i(Ljava/lang/Object;Ljava/lang/String;)V
   0146: invoke-virtual {v2} Ljava/lang/String;->hashCode()I
   0149: move-result v8
   014a: sparse-switch v8, data@01e4
   014d: goto/16 -> 01bf
   014f: const-string v0, 'dynamic'
   0151: invoke-virtual {v2,v0} Ljava/lang/String;->equals(Ljava/lang/Object;)Z
   0154: move-result v0
   0155: if-nez v0, -> 0159
   0157: goto/16 -> 01bf
   0159: new-instance v15, Lir/divar/chat/notification/entity/NotificationPayload$DynamicActionPayload;
   015b: sget-object v0, Lmarketing/ServerSideDynamicLink;->ADAPTER:Lcom/squareup/wire/ProtoAdapter;
   015d: if-nez v14, -> 0160
   015f: goto -> 0161
   0160: move-object v6, v14
   0161: invoke-virtual {v6} Ljava/lang/String;->getBytes()[B
   0164: move-result-object v6
   0165: array-length v8, v6
   0166: sget-object v10, LWC/a;->c:[B
   0168: invoke-static {v6,v10,v8} LWC/a;->i([B[BI)[B
   016b: move-result-object v6
   016c: invoke-virtual {v0,v6} Lcom/squareup/wire/ProtoAdapter;->decode([B)Ljava/lang/Object;
   016f: move-result-object v0
   0170: check-cast v0, Lmarketing/ServerSideDynamicLink;
   0172: invoke-direct {v15,v0} Lir/divar/chat/notification/entity/NotificationPayload$DynamicActionPayload;-><init>(Lmarketing/ServerSideDynamicLink;)V
   0175: move-object v0, v15
   0176: goto -> 01ca
   0177: const-string v0, 'voip'
   0179: invoke-virtual {v2,v0} Ljava/lang/String;->equals(Ljava/lang/Object;)Z
   017c: move-result v0
   017d: if-nez v0, -> 0180
   017f: goto -> 01bf
   0180: new-instance v0, Lir/divar/chat/notification/entity/NotificationPayload$VoIPPayload;
   0182: invoke-direct {v0,v15} Lir/divar/chat/notification/entity/NotificationPayload$VoIPPayload;-><init>(Ljava/lang/String;)V
   0185: goto -> 01ca
   0186: const-string v8, 'chat'
   0188: invoke-virtual {v2,v8} Ljava/lang/String;->equals(Ljava/lang/Object;)Z
   018b: move-result v8
   018c: if-nez v8, -> 018f
   018e: goto -> 01bf
   018f: if-nez v0, -> 0192
   0191: move-object v0, v6
   0192: if-nez v10, -> 0195
   0194: goto -> 0196
   0195: move-object v6, v10
   0196: new-instance v15, Lir/divar/chat/notification/entity/NotificationPayload$ChatPayload;
   0198: invoke-direct {v15,v0,v13,v6} Lir/divar/chat/notification/entity/NotificationPayload$ChatPayload;-><init>(Ljava/lang/String;ZLjava/lang/String;)V
   019b: goto -> 0175
   019c: const-string v0, 'postchi'
   019e: invoke-virtual {v2,v0} Ljava/lang/String;->equals(Ljava/lang/Object;)Z
   01a1: move-result v0
   01a2: if-nez v0, -> 01a5
   01a4: goto -> 01bf
   01a5: new-instance v0, Lir/divar/chat/notification/entity/NotificationPayload$PostmanPayload;
   01a7: const/4 v6, 1
   01a8: const/4 v15, 0
   01a9: invoke-direct {v0,v15,v6,v15} Lir/divar/chat/notification/entity/NotificationPayload$PostmanPayload;-><init>(Ljava/lang/String;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
   01ac: goto -> 01ca
   01ad: invoke-virtual {v2,v12} Ljava/lang/String;->equals(Ljava/lang/Object;)Z
   01b0: move-result v0
   01b1: if-nez v0, -> 01b4
   01b3: goto -> 01bf
   01b4: sget-object v0, Lir/divar/chat/notification/entity/NotificationPayload$SilentPayload;->INSTANCE:Lir/divar/chat/notification/entity/NotificationPayload$SilentPayload;
   01b6: goto -> 01ca
   01b7: const-string v0, 'manage'
   01b9: invoke-virtual {v2,v0} Ljava/lang/String;->equals(Ljava/lang/Object;)Z
   01bc: move-result v0
   01bd: if-nez v0, -> 01c1
   01bf: const/4 v0, 0
   01c0: goto -> 01ca
   01c1: new-instance v0, Lir/divar/chat/notification/entity/NotificationPayload$ManagePayload;
   01c3: if-nez v11, -> 01c6
   01c5: goto -> 01c7
   01c6: move-object v6, v11
   01c7: invoke-direct {v0,v6} Lir/divar/chat/notification/entity/NotificationPayload$ManagePayload;-><init>(Ljava/lang/String;)V
   01ca: if-nez v0, -> 01cd
   01cc: goto -> 01e2
   01cd: move-object v8, v4
   01ce: move-object v4, v2
   01cf: new-instance v2, Lir/divar/chat/notification/entity/Notification;
   01d1: move-object v6, v9
   01d2: move-object v9, v0
   01d3: invoke-direct/range {v2..v9} Lir/divar/chat/notification/entity/Notification;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lir/divar/chat/notification/entity/NotificationPayload;)V
   01d6: new-instance v0, LWk/e;
   01d8: const/4 v15, 0
   01d9: invoke-direct {v0,v1,v2,v15} LWk/e;-><init>(LWk/g;Lir/divar/chat/notification/entity/Notification;LNE/c;)V
   01dc: const/4 v2, 3
   01dd: iget-object v3, v1, LWk/g;->a:LDG/B;
   01df: invoke-static {v3,v15,v15,v0,v2} LDG/E;->E(LDG/B;LNE/h;LDG/C;LYE/n;I)LDG/v0;
   01e2: return-void
   01e3: nop
==  LWk/g;->g(Lir/divar/chat/notification/entity/Notification;)V
