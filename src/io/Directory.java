package io;


import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class Directory {
    public static File[] local(File dir, final String regex) {
        return dir.listFiles(
                new FilenameFilter() {
                    private Pattern pattern = Pattern.compile(regex);

                    @Override
                    public boolean accept(File dir, String name) {
                        return new File(name).getName().matches(regex);
//                        return false;
                    }
                }
        );
    }

    public static File[] loacl(String path, final String regex) {
        return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();

        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            return "dirs: " + dirs + "\n\nfiles" + files;
        }

        public static TreeInfo walk(String start, String regex) {
            return recurseDirs(new File(start), regex);
        }

        public static TreeInfo walk(String string) {
            return recurseDirs(new File(string), ".");
        }

        private static TreeInfo recurseDirs(File file, String regex) {
            TreeInfo result = new TreeInfo();
            for (File item : file.listFiles()) {
                if (item.isDirectory()) {
                    result.dirs.add(item);
                    result.addAll(recurseDirs(item, regex));
                } else if (item.getName().matches(regex)) {
                    result.files.add(item);
                }
            }
            return result;
        }

        public static void main(String[] args) {
            System.out.println(walk("."));
        }

    }



}
