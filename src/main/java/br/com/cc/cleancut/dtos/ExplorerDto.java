package br.com.cc.cleancut.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExplorerDto {

    List<ImageDto> imageDtoList;
}
