package co.sudoers.virtualnotes.util;

import co.sudoers.virtualnotes.dto.GetNoteDto;
import co.sudoers.virtualnotes.entity.Topic;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ExtractToExcel {

    public ByteArrayInputStream extract(List<GetNoteDto> list) {
        Workbook workbook = createWorkbook();
        createSheet(workbook, list);
        return writeToFile(workbook);
    }

    private Workbook createWorkbook() {
        return new XSSFWorkbook();
    }

    private void createSheet(Workbook workbook, List<GetNoteDto> list) {
        List<Topic> existingTopicList = new ArrayList<>();
        Sheet sheet = null;

        if (CollectionUtils.isEmpty(list)) {
            throw new IllegalArgumentException("There is no data to extract");
        }

        for (GetNoteDto getNoteDto : list) {
            if (CollectionUtils.isEmpty(existingTopicList)) {
                existingTopicList.add(getNoteDto.getTopic());
            } else if(!existingTopicList.contains(getNoteDto.getTopic())) {
                existingTopicList.add(getNoteDto.getTopic());
            }
        }

        if (!CollectionUtils.isEmpty(existingTopicList)) {
            for (Topic topic : existingTopicList) {
                sheet = workbook.createSheet(topic.getTopicName());
                sheet.setColumnWidth(0, 8000);
                sheet.setColumnWidth(1, 8000);
                headerStyle(workbook, sheet);

                // Get related notes according to the topic
                List<GetNoteDto> collect = list.stream()
                        .filter(noteDto -> Objects.equals(noteDto.getTopic().getTopicId(), topic.getTopicId()))
                        .collect(Collectors.toList());

                for (int i = 0; i < collect.size(); i++) {
                    Row row = sheet.createRow(i+1);
                    contentStyle(workbook, row, collect.get(i));
                }
            }
        }
    }

    private void headerStyle(Workbook workbook, Sheet sheet) {
        Row header = sheet.createRow(0);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);
        headerStyle.setFont(font);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("Topic");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("Note");
        headerCell.setCellStyle(headerStyle);
    }

    private void contentStyle(Workbook workbook, Row row, GetNoteDto noteDto) {
        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);

        Cell cell = row.createCell(0);
        cell.setCellValue(noteDto.getTopic().getTopicName());
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue(noteDto.getNote());
        cell.setCellStyle(style);
    }

    private ByteArrayInputStream writeToFile(Workbook workbook) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

}
