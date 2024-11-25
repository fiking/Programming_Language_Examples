//
//  RunJavascriptcore.swift
//  hello_javascriptcore
//
//  Created by language-vm on 2024/11/25.
//

import Foundation
import JavaScriptCore

func runJavascriptcore() {
    print("javascriptcore run start!")

    let vm = JSVirtualMachine()
    let context = JSContext(virtualMachine: vm)!
    let value = context.evaluateScript("1+2*3")
    if let intValue = value?.toInt32() {
        print("value = \(intValue)")
    }

    print("javascriptcore run end!")
}
