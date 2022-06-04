import {defineConfig} from 'vitepress'

export default defineConfig({
  lang: 'en-US',
  title: 'Lair',
  description: 'Vue and SpringBoot static template',

  lastUpdated: true,

  head:[
    ['link', { rel: 'icon', href: '/logo.svg', type: 'image/svg+xml' }],
  ],

  themeConfig: {
    logo:'/logo.svg',
    nav:nav(),
    editLink: {
      repo: 'elonehoo/static',
      branch: 'main',
      dir: 'docs',
      text: 'Edit this page on GitHub'
    },

    socialLinks: [
      { icon: 'github', link: 'https://github.com/elonehoo/static' }
    ],

    footer: {
      message: 'Released under the MIT License.',
      copyright: 'Copyright © 2022-present Elone Hoo'
    },
  }
})

function nav(){
  return [
    { text: 'Guide', link: '/guide/getting-started', activeMatch: '/guide/' },
    { text: 'app', link: '/app/getting-started', activeMatch: '/app/' },
    { text: 'web', link: '/web/getting-started', activeMatch: '/web/' },
  ]
}
