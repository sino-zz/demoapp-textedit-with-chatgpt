package com.sample.texteditapp.service;

import com.sample.texteditapp.dto.Command;
import com.sample.texteditapp.dto.Output;

public interface AppService {

	Output processEdits(  Command command);
}
